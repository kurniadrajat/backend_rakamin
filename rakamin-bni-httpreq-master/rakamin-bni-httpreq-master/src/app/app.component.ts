import { Component, OnInit } from '@angular/core';
import { Tutorial } from './models/tutorial.model';
import { TutorialService } from './services/tutorial.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'rakamin';
  tutorials: Tutorial[] = [];
  selectedTutorial: Tutorial | undefined; // Tambahkan properti selectedTutorial

  constructor(
    private tutorialService: TutorialService
  ) {

  }

  ngOnInit(): void {
    this.getDataTutorialId(4)
    this.getDataTutorial()
  }

  getDataTutorial() {
    this.tutorialService.getAll().subscribe((res) => {
      console.log('success get data',res);
      this.tutorials = res;
    })
  }

  getDataTutorialId(id: any) {
    this.tutorialService.get(id).subscribe((res) => {
      console.log('success get data',res);
    })
  }

  // Post data: component
  postDataTutorial(title: string, desc: string){
    this.tutorialService.post(title, desc).subscribe((item) => {
      console.log('success post data', item)
    })
  }

  // Delete data: component
  deleteDataTutorial(id:any){
    this.tutorialService.delete(id).subscribe(() =>{
      console.log('success delete data')
    })
  }

  // editDataTutorial(id:any){
  //   this.tutorialService.findByTitle(id).subscribe(() =>{
  //     console.log('success edit data')
  //   })
  // }

  editDataTutorial(id: any) {
    // Anda dapat menampilkan formulir pengeditan atau
    // melakukan logika yang diperlukan untuk mengedit data
    this.tutorialService.get(id).subscribe((tutorial) => {
      this.selectedTutorial = tutorial;
    });
  }
  
  updateDataTutorial(id: any, title: string, desc: string) {
    const dataToUpdate = { title: title, desc: desc };
    this.tutorialService.update(id, dataToUpdate).subscribe(() => {
      console.log('Success updating data');
      // Setelah berhasil memperbarui data, panggil metode untuk mendapatkan data terbaru
      this.getDataTutorial();
      // Reset selectedTutorial untuk menutup formulir pengeditan
      this.selectedTutorial = undefined;
    });
  }
}
