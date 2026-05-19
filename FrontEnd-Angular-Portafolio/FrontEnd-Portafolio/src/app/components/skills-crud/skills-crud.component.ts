import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-skills-crud',
  templateUrl: './skills-crud.component.html',
  styleUrls: ['./skills-crud.component.css']
})
export class SkillsCrudComponent implements OnInit {
 @Input() visible = false;
 @Input() data: any;
 @Input() modo!: 'crear' | 'editar';
 @Input() tipo!: 'soft' | 'hard';
 @Output() close = new EventEmitter<void>();
 @Output() save = new EventEmitter<any>();

 form: FormGroup;

constructor(private fb: FormBuilder, private messageService: MessageService) {



  this.form = this.fb.group({
    nombre: ['',
        [Validators.required]
      ],
    descripcion: ['',
        [Validators.required]
      ],
    nivel: ['',
       [
       Validators.required,
       Validators.min(0),
       Validators.max(100)
       ]
      ],
    img: ['']
  });
}

  ngOnInit(): void {
  }

  ngOnChanges() {
  if (this.modo === 'editar' && this.data) {
    this.form.patchValue(this.data);
  }
  if (this.modo === 'crear') {
    this.form.reset();
  }
}

onClose() {
  this.visible = false;
  this.close.emit();
  this.form.reset();
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


}
