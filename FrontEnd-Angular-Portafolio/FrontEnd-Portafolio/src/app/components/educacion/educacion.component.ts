import { AfterViewInit,Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/services/educacion.service';
import {educacion} from 'src/app/models/educacion.model';

declare var FinisherHeader: any;

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
  export class EducacionComponent implements OnInit, AfterViewInit {
    ed: educacion[]=[];
    constructor(private educacionService: EducacionService) { }

    ngOnInit(): void {
      this.cargarEducacion();
    }

   ngAfterViewInit(): void {
  setTimeout(() => {
    new FinisherHeader({
      count: 17,
      size: {
        min: 17,
        max: 1027,
        pulse: 0.4
      },
      speed: {
        x: { min: 0.6, max: 3 },
        y: { min: 0.6, max: 3 }
      },
      colors: {
        background: "#161616",
        particles: [
          "#969595",
          "#444647",
          "#3b3b47",
          "#2c1e22"
        ]
      },
      blending: "lighten",
      opacity: {
        center: 0.6,
        edge: 0
      },
      skew: 0,
      shapes: ["c"]
    });
  }, 100);
}

   cargarEducacion(): void {
  this.educacionService.getEducacion().subscribe(data => {
    this.ed = data;

    setTimeout(() => {
      new FinisherHeader({
        count: 17,
        size: {
          min: 17,
          max: 1500,
          pulse: 0.4
        },
        speed: {
          x: { min: 0.6, max: 3 },
          y: { min: 0.6, max: 3 }
        },
        colors: {
          background: "#161616",
          particles: [
            "#4b4948",
            "#161d20",
            "#3b3b47",
            "#2c1e22"
          ]
        },
        blending: "lighten",
        opacity: {
          center: 0.6,
          edge: 0
        },
        skew: 0,
        shapes: ["c"]
      });
    }, 100);
  });
}

}
