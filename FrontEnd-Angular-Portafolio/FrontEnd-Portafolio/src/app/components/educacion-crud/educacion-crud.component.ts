import { Component, Input, Output, EventEmitter, OnChanges } from '@angular/core';
import { FormBuilder, FormGroup , Validators, AbstractControl} from '@angular/forms';
import { MessageService } from 'primeng/api';

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

  constructor(private fb: FormBuilder, private messageService: MessageService) {
  
  this.form = this.fb.group({
      titulo: ['',
    [Validators.required]
  ],
      institucion: ['',
    [Validators.required]
  ],
    periodo_inicio: [
    '',
    [
      Validators.required,
      Validators.min(1950),
      Validators.max(2030)
    ]
  ],

  periodo_final: [
    '',
    [
      Validators.required,
      Validators.min(1950),
      Validators.max(2040)
    ]
  ],
      img: [''],
      tipo: [''],
      link: ['']
    },
  {
  validators: this.validarRangoAnios
  });
  }

 validarRangoAnios(form: AbstractControl) {
    const inicio = form.get('periodo_inicio')?.value;
    const fin = form.get('periodo_final')?.value;
    if (
      inicio &&
      fin &&
      fin < inicio
    ) {
      return { rangoInvalido: true };
    }
    return null;
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
          this.messageService.add({
      severity: 'warn',
      summary: 'Formulario inválido',
      detail: 'Completá todos los campos correctamente'
    });

    }
  }

onClose() {
    this.visible = false;
    this.close.emit();
    this.form.reset(); 
  }

}
