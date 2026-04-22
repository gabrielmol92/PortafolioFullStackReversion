export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    email: String;
    titulo: String;
    img : String;

   constructor(nombre: String , apellido: String, email: String, titulo: String, img: String){
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.titulo = titulo;
            this.img = img;

   }
}