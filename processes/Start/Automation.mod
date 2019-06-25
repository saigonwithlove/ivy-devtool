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
>Proto An0 An0 Automation #zField
An0 f3 type AutomationData #txt
An0 f3 400 143 30 30 0 15 #rect
An0 f3 @|EndIcon #fIcon
An0 f5 expr out #txt
An0 f5 174 158 400 158 #arcP
An0 f4 outerBean "saigonwithlove.ivy.devtool.automation.SystemEventRegister" #txt
An0 f4 outLink eventLink.ivp #txt
An0 f4 type AutomationData #txt
An0 f4 @C|.responsibility Everybody #txt
An0 f4 144 143 30 30 0 15 #rect
An0 f4 @|StartEventIcon #fIcon
>Proto An0 .type AutomationData #txt
>Proto An0 .processKind NORMAL #txt
>Proto An0 0 0 32 24 18 0 #rect
>Proto An0 @|BIcon #fIcon
An0 f4 mainOut f5 tail #connect
An0 f5 head f3 mainIn #connect
