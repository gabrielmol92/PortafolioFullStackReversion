import { Component, Input, Output, EventEmitter, OnChanges } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-acerca-de-mi-edit',
  templateUrl: './acerca-de-mi-edit.component.html',
  styleUrls: ['./acerca-de-mi-edit.component.css']
})

export class AcercaDeMiEditComponent implements OnChanges {

  @Input() visible: boolean = false;
  @Input() data: any;

  @Output() close = new EventEmitter<void>();
  @Output() save = new EventEmitter<any>();

  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      nombre: [''],
      apellido: [''],
      email:[''],
      titulo: [''],
      img: ['']
    });
  }

  ngOnChanges() {
    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  onSave() {
    this.save.emit(this.form.value);
  }

  onClose() {
    this.close.emit();
  }
}