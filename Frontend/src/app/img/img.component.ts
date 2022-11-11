import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-img',
  templateUrl: './img.component.html',
  styleUrls: ['./img.component.css']
})
export class ImgComponent implements OnInit {
  constructor() { }
  @Input() public image: any;
  retrieveImage: any;
  ngOnInit(): void {
    this.retrieveImage = 'data:image/jpg;base64,' +this.image;
  }
}
