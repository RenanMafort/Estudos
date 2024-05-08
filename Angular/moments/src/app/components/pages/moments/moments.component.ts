import {Component, OnInit} from '@angular/core';
import {Moments} from "../../../Moments";
import {MomentService} from "../../../services/moment.service";
import {ActivatedRoute, Router} from "@angular/router";
import {environment} from "../../../../environments/environment.development";
import {FormGroup,FormControl,Validators, FormGroupDirective} from "@angular/forms";
import {faTimes, faEdit} from "@fortawesome/free-solid-svg-icons";
import {MessagesService} from "../../../services/messages.service";
import {CommentService} from "../../../services/comment.service";
import {Comment} from "../../../Comment";

@Component({
  selector: 'app-moments',
  templateUrl: './moments.component.html',
  styleUrls: ['./moments.component.css']
})
export class MomentsComponent implements OnInit {
  moment?: Moments;
  baseApiUrl = environment.baseApiUrl;
  faTimes = faTimes;
  faEdit = faEdit;

  commentForm! : FormGroup;

  constructor(private momentService: MomentService, private route: ActivatedRoute,
              private messageService: MessagesService,
              private router:Router,
              private commentService: CommentService) {
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.momentService.getMoment(id).subscribe(moment =>
      this.moment = moment.data);

    this.commentForm = new FormGroup({
      text: new FormControl('',[Validators.required]),
      username: new FormControl('',[Validators.required]),
    });
  }

  async removeHandler(id: number) {
  await this.momentService.removeMoment(id).subscribe();

  this.messageService.add("Momento excluido com sucesso!");
  this.router.navigate(['/'])
  }

  get text(){
    return this.commentForm.get('text')!;
  }

  get username(){
    return this.commentForm.get('username')!;
  }

  async onSubmit(formDirective: FormGroupDirective ){
    if (this.commentForm.invalid){
      return;
    }

    const data: Comment = this.commentForm.value;

    data.momentId = Number(this.moment!.id);

    await this.commentService.createComment(data)
      .subscribe((comment) =>
    this.moment!.comments!.push(comment.data));

    this.messageService.add("Comentário adicionado!")

    this.commentForm.reset();

    formDirective.resetForm();
  }

}
