[Ivy]
16AE38ED14569A2A 7.5.0 #module
>Proto >Proto Collection #zClass
An0 Automation Big #zClass
An0 B #cInfo
An0 #process
An0 @TextInP .type .type #zField
An0 @TextInP .processKind .processKind #zField
An0 @AnnotationInP-0n ai ai #zField
An0 @MessageFlowInP-0n messageIn messageIn #zField
An0 @MessageFlowOutP-0n messageOut messageOut #zField
An0 @TextInP .xml .xml #zField
An0 @TextInP .responsibility .responsibility #zField
An0 @EndTask f3 '' #zField
An0 @PushWFArc f5 '' #zField
An0 @StartEvent f4 '' #zField
An0 @StartRequest f0 '' #zField
An0 @GridStep f1 '' #zField
An0 @PushWFArc f2 '' #zField
>Proto An0 An0 Automation #zField
An0 f3 432 111 30 30 0 15 #rect
An0 f3 @|EndIcon #fIcon
An0 f5 expr out #txt
An0 f5 206 126 432 126 #arcP
An0 f4 outerBean "saigonwithlove.ivy.devtool.automation.SystemEventRegister" #txt
An0 f4 outLink eventLink.ivp #txt
An0 f4 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
An0 f4 @C|.responsibility Everybody #txt
An0 f4 176 111 30 30 0 15 #rect
An0 f4 @|StartEventIcon #fIcon
An0 f0 outLink engine.ivp #txt
An0 f0 inParamDecl '<> param;' #txt
An0 f0 requestEnabled true #txt
An0 f0 triggerEnabled false #txt
An0 f0 callSignature engine() #txt
An0 f0 persist false #txt
An0 f0 taskData 'TaskTriggered.EXPRI=2
TaskTriggered.EXROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.PRI=2
TaskTriggered.ROL=Everybody
TaskTriggered.TYPE=0' #txt
An0 f0 caseData businessCase.attach=true #txt
An0 f0 showInStartList 1 #txt
An0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>engine.ivp</name>
        <nameStyle>10,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
An0 f0 @C|.responsibility Everybody #txt
An0 f0 177 401 30 30 -32 17 #rect
An0 f0 @|StartRequestIcon #fIcon
An0 f1 actionTable 'out=in;
' #txt
An0 f1 actionCode 'import saigonwithlove.ivy.devtool.api.EngineApi;
EngineApi.newInstance().handleRequest(ivy.wf.getApplication(), ivy.request, ivy.response);' #txt
An0 f1 security system #txt
An0 f1 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>execute</name>
        <nameStyle>7
</nameStyle>
    </language>
</elementInfo>
' #txt
An0 f1 392 394 112 44 -25 -7 #rect
An0 f1 @|StepIcon #fIcon
An0 f2 expr out #txt
An0 f2 207 416 392 416 #arcP
>Proto An0 .type saigonwithlove.ivy.devtool.automation.AutomationData #txt
>Proto An0 .processKind NORMAL #txt
>Proto An0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel></swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
    </language>
    <swimlaneOrientation>false</swimlaneOrientation>
    <swimlaneSize>288</swimlaneSize>
    <swimlaneSize>256</swimlaneSize>
    <swimlaneColor gradient="false">-3355393</swimlaneColor>
    <swimlaneColor gradient="false">-13057</swimlaneColor>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneSpaceBefore>0</swimlaneSpaceBefore>
    <swimlaneSpaceBefore>0</swimlaneSpaceBefore>
</elementInfo>
' #txt
>Proto An0 0 0 32 24 18 0 #rect
>Proto An0 @|BIcon #fIcon
An0 f4 mainOut f5 tail #connect
An0 f5 head f3 mainIn #connect
An0 f0 mainOut f2 tail #connect
An0 f2 head f1 mainIn #connect
