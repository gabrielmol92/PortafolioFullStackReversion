import { Component, Input, Output, EventEmitter, OnChanges } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-educacion-crud',
  templateUrl: './educacion-crud.component.html',
  styleUrls: ['./educacion-crud.component.css']
})
export class EducacionCrudComponent implements OnChanges {

@Input() visible: boolean = false;
  @Input() data: any;

  @Input() modo!: 'crear' | 'editar';
  @Output() close = new EventEmitter<void>();
  @Output() save = new EventEmitter<any>();

  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      titulo: [''],
      institucion: [''],
      periodo_inicio:[''],
      periodo_final: [''],
      img: [''],
      tipo: [''],
      link: ['']
    });
  }

ngOnChanges() {
  this.form.reset();
  if (this.modo === 'editar' && this.data) {
    this.form.patchValue(this.data);
  }
  if (this.modo === 'crear' && this.data) {
    this.form.patchValue(this.data);
  }
}

  onSave() {
    if (this.form.valid) {
      this.save.emit(this.form.value);
    } else {
      this.form.markAllAsTouched();
    }
  }

onClose() {
    this.visible = false;
    this.close.emit();
    this.form.reset(); 
  }

}
