import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  baseurl:string="http://localhost:9000/api/v1/post"



  constructor(private http:HttpClient) { }

  getPost():Observable<Post[]>{
    return this.http.get<Post[]>(`${this.baseurl}/all`);
  }

  addPost(post:Post):Observable<Object>
  {
    return this.http.post(`${this.baseurl}/add`,post);
  }

  addPoints(post:Post,id:number):Observable<Object>{
    return this.http.put(`${this.baseurl}/points/${id}`,post);
  }
}
