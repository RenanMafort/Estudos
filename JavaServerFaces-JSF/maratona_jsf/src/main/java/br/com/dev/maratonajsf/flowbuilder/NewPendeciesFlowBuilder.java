package br.com.dev.maratonajsf.flowbuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

/**
 * Created by Renan on 17/01/2023.
 */
public class NewPendeciesFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder){
        String flowId = "newpendecies";
        flowBuilder.id("",flowId);
        flowBuilder.viewNode(flowId,"/newpendencies/newpendencies.xhtml").markAsStartNode();
        flowBuilder.returnNode("proceedToNewRegistration3")
                .fromOutcome("/newregistration/newregistration3.xhtml");
        flowBuilder.returnNode("exitToNewInicio")
                .fromOutcome("/newregistration/newregistration.xhtml");
        flowBuilder.inboundParameter("userName","#{testFlowBuilderNestedBean.userName}");
        flowBuilder.inboundParameter("userSurname","#{testFlowBuilderNestedBean.userSurname}");

        return flowBuilder.getFlow();

    }
}
