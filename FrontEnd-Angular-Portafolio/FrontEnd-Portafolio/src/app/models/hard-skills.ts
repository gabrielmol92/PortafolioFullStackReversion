export class hardSkills {
    id? : number;
    nombre : String;
    nivel : number;
    img : String;

    constructor(nombre: String, nivel: number, img : String){
        this.nombre = nombre;
        this.nivel = nivel;
        this.img = img;
    }
}
