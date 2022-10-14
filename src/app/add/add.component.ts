import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { PostService } from '../post.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  postForm!:FormGroup;

  constructor(private service:PostService, private formBuilder:FormBuilder,private dialogref:MatDialogRef<AddComponent>) { }

  ngOnInit(): void {
    this.postForm=this.formBuilder.group({
      name:['',Validators.required],
      date:['',Validators.required],
      imgUrl:['',Validators.required]
    })

  }

  addPost(){
    this.service.addPost(this.postForm.value).subscribe(data=>{
      this.dialogref.close();
      console.log(data);
    },error=>alert("error"))
  }

}
