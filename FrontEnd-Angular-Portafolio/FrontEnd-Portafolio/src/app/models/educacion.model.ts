export class educacion{
   id?: number;
   titulo: String;
   institucion: String;
   periodo_inicio: String;
   periodo_final: String;
   img: String;
   tipo: String;
   link: String;

   constructor(titulo: String , institucion: String, periodo_inicio: String, periodo_final: String, img: String, tipo: String, link: String){
    this.titulo = titulo;
    this.institucion = institucion;
    this.periodo_inicio = periodo_inicio;
    this.periodo_final = periodo_final
    this.img = img;
    this.tipo = tipo;
    this.link = link;
}


}