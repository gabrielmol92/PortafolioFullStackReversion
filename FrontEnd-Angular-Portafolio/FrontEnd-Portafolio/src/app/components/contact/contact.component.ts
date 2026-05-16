import { Component, OnInit } from '@angular/core';
import emailjs from '@emailjs/browser';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  nombre: string = '';
  email: string = '';
  mensaje: string = '';

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
  }

 enviarMensaje(): void {
  const templateParams = {
    nombre: this.nombre,
    email: this.email,
    mensaje: this.mensaje
  };

  emailjs.send(
    'service_62w0o43',
    'template_ki0ncs1',
    templateParams,
    'D4AVBHqfW-KCLXgTc'
  )
  .then(() => {
    this.messageService.add({
      severity: 'success',
      summary: 'Mensaje enviado',
      detail: 'Tu mensaje fue enviado correctamente'
    });
    this.limpiarFormulario();
  })
  .catch((error) => {
    console.error('Error al enviar:', error);
    this.messageService.add({
      severity: 'error',
      summary: 'Error',
      detail: 'No se pudo enviar el mensaje'
    });
  });
}

private limpiarFormulario(): void {
  this.nombre = '';
  this.email = '';
  this.mensaje = '';
}

}