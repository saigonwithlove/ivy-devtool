[Ivy]
16AE38ED14569A2A 3.20 #module
>Proto >Proto Collection #zClass
An0 Automation Big #zClass
An0 B #cInfo
An0 #process
An0 @TextInP .resExport .resExport #zField
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
An0 @StartRequest f6 '' #zField
An0 @EndTask f7 '' #zField
An0 @GridStep f9 '' #zField
An0 @PushWFArc f10 '' #zField
An0 @PushWFArc f8 '' #zField
>Proto An0 An0 Automation #zField
An0 f3 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
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
An0 f0 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
An0 f0 inParamDecl '<> param;' #txt
An0 f0 actionDecl 'saigonwithlove.ivy.devtool.automation.AutomationData out;
' #txt
An0 f0 guid 16BE5A220A2B0DAF #txt
An0 f0 requestEnabled true #txt
An0 f0 triggerEnabled false #txt
An0 f0 callSignature engine() #txt
An0 f0 persist false #txt
An0 f0 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
TaskTriggered.EXROL=Everybody' #txt
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
An0 f1 actionDecl 'saigonwithlove.ivy.devtool.automation.AutomationData out;
' #txt
An0 f1 actionTable 'out=in;
' #txt
An0 f1 actionCode 'import saigonwithlove.ivy.devtool.engine.EngineApi;
EngineApi.newInstance().handleRequest(ivy.wf.getApplication(), ivy.request, ivy.response);' #txt
An0 f1 security system #txt
An0 f1 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
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
An0 f6 outLink initialize.ivp #txt
An0 f6 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
An0 f6 inParamDecl '<> param;' #txt
An0 f6 actionDecl 'saigonwithlove.ivy.devtool.automation.AutomationData out;
' #txt
An0 f6 guid 16FADD7BC462DAB2 #txt
An0 f6 requestEnabled true #txt
An0 f6 triggerEnabled false #txt
An0 f6 callSignature initialize() #txt
An0 f6 persist false #txt
An0 f6 taskData 'TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
TaskTriggered.EXROL=Everybody' #txt
An0 f6 caseData businessCase.attach=true #txt
An0 f6 showInStartList 1 #txt
An0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>initialize.ivp</name>
    </language>
</elementInfo>
' #txt
An0 f6 @C|.responsibility Everybody #txt
An0 f6 177 625 30 30 -35 17 #rect
An0 f6 @|StartRequestIcon #fIcon
An0 f7 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
An0 f7 561 625 30 30 0 15 #rect
An0 f7 @|EndIcon #fIcon
An0 f9 actionDecl 'saigonwithlove.ivy.devtool.automation.AutomationData out;
' #txt
An0 f9 actionTable 'out=in;
' #txt
An0 f9 actionCode 'import saigonwithlove.ivy.devtool.automation.Initializer;
Initializer.initialize();' #txt
An0 f9 security system #txt
An0 f9 type saigonwithlove.ivy.devtool.automation.AutomationData #txt
An0 f9 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>initialize</name>
        <nameStyle>10
</nameStyle>
    </language>
</elementInfo>
' #txt
An0 f9 296 618 112 44 -24 -7 #rect
An0 f9 @|StepIcon #fIcon
An0 f10 expr out #txt
An0 f10 207 640 296 640 #arcP
An0 f8 expr out #txt
An0 f8 408 640 561 640 #arcP
>Proto An0 .type saigonwithlove.ivy.devtool.automation.AutomationData #txt
>Proto An0 .processKind NORMAL #txt
>Proto An0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel></swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
        <swimlaneLabel></swimlaneLabel>
    </language>
    <swimlaneOrientation>false</swimlaneOrientation>
    <swimlaneSize>288</swimlaneSize>
    <swimlaneSize>256</swimlaneSize>
    <swimlaneSize>192</swimlaneSize>
    <swimlaneColor gradient="false">-3355393</swimlaneColor>
    <swimlaneColor gradient="false">-13057</swimlaneColor>
    <swimlaneColor gradient="false">-3342388</swimlaneColor>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneSpaceBefore>0</swimlaneSpaceBefore>
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
An0 f6 mainOut f10 tail #connect
An0 f10 head f9 mainIn #connect
An0 f9 mainOut f8 tail #connect
An0 f8 head f7 mainIn #connect
