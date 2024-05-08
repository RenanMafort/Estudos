import {RouterModule, Routes} from "@angular/router";
import {FirstComponentComponent} from "./components/first-component/first-component.component";
import {ListRenderComponent} from "./components/list-render/list-render.component";
import {NgModule} from "@angular/core";
import {IfRenderComponent} from "./components/if-render/if-render.component";
import {PipesOperatorComponent} from "./components/pipes-operator/pipes-operator.component";
import {ItemDetailComponent} from "./components/item-detail/item-detail.component";

const routes: Routes = [
  {path: '', component: FirstComponentComponent},
  {path: 'list', component: ListRenderComponent},
  {path: 'list/:id', component: ItemDetailComponent},
  {path: 'render', component: IfRenderComponent},
  {path: 'pipe', component: PipesOperatorComponent},
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule]
})

export class AppRoutingModule{}
