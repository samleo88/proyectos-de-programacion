import { Component, OnInit} from '@angular/core';
import {Input} from '@angular/core';


@Component({
  selector: 'app-text',
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css']
})
export class TextComponent implements OnInit {
  @Input() nombre: string;
  @Input() edad: number;
  @Input() email: string;
  constructor() { }

  ngOnInit() {
  }

}
