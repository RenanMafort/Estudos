package br.com.dev.maratonajsf.clientbehavior;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

/**
 * Created by Renan on 03/02/2023.
 */
@FacesBehavior(value = "confirm")
public class ConfirmeDeleteBehavior extends ClientBehaviorBase{
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return "return confirm('Vc tem certeza ? ');";
    }
}
