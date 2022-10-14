import { Component,OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { AddComponent } from './add/add.component';
import { Post } from './post';
import { PostService } from './post.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'rankingSystem';
  post:Post[];
  totalLength:number;
  page:number=1;

  constructor(private dialog:MatDialog,private service:PostService){}
  
  ngOnInit(): void {

    this.getAll();
  }

  add(){
    this.dialog.open(AddComponent,{
      width:"50%"
    }).afterClosed().subscribe(val=>{
      this.getAll();
    })
  }

  getAll()
  {
     this.service.getPost().subscribe(data=>{
      this.post=data;
      this.totalLength=this.post.length;
     })
  }

  addPoints(post:Post,id:number){
    return this.service.addPoints(post,id).subscribe(data=>{
      this.getAll();
    })
  }
  
}
