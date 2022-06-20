from Project import *

prj = Project(name="Spring", duration=12)
# Project resources / team members
LG = Ressource(id='LG', name="Geoffrey LALIC")
NR = Ressource(id='NR', name="Rémy NGUYEN")
KD = Ressource(id='KD', name="Djade KHALDI")
MA = Ressource(id='MA', name="Axel MAISSA")
SKA = Ressource(id='SKA', name="Aryamaan KUNWAR")
BP = Ressource(id='BP', name="Paul BUREL")
team = [LG, NR, KD, MA, SKA, BP]
for person in team:
    prj.add_ressource(person)

# Project tasks
TD = Task(id='TD', desc='Heure de TD dédié au projet ', load=6, actual=6)
R = Task(id='R', desc='Réunion Team', load=4, actual=1)
PT = Task(id='PT', desc='Project Tracking', load=7, actual=4)
DJ = Task(id='DJ', desc='Module Joueur', load=0, actual=0)
DJC = Task(id='DJC', desc='Architecture de la classe Joueur', load=2, actual=1)
DJF = Task(id='DJF', desc='Développement fonctions', load=4, actual=5)
DJWS = Task(id='DJWS', desc='Développement WebServices Joueur', load=2, actual=2)
DP = Task(id='DP', desc='Module Partie', load=0, actual=0)
DPC = Task(id='DPC', desc='Architecture de la classe Partie', load=2, actual=1)
DPF = Task(id='DPF', desc='Développement fonctions Partie', load=7, actual=5)
DPWS = Task(id='DPWS', desc='Développement WebServices Partie', load=2, actual=2)
DA = Task(id='DA', desc='Module Appariement', load=0, actual=0)
DAC = Task(id='DAC', desc='Architecture de la classe Appariement', load=3, actual=1.5)
DAF = Task(id='DDAFAC', desc='Développement fonctions Appariement', load=2, actual=2)
DAWS = Task(id='DAWS', desc='Développement WebServices Appariement', load=2, actual=2)
DAN = Task(id='DAN', desc='Module Anagrammeur', load=0, actual=0)
DANC = Task(id='DANC', desc='Architecture de la classe Anagrammeur', load=3, actual=1)
DANF = Task(id='DANF', desc='Développement fonctions Anagrammeur', load=7, actual=3)
DANWS = Task(id='DANWS', desc='Développement WebServices Anagrammeur', load=2, actual=2)
DC = Task(id='DC', desc='Module Commun', load=0, actual=0)
DCC = Task(id='DCC', desc='Architecture des classes Commun', load=1, actual=1)
DCF = Task(id='DCF', desc='Développement fonctions Commun', load=4, actual=3)
SWS = Task(id='SWS', desc='Architecture Spring/WebService', load=4, actual=6)
DOCK = Task(id='DOCK', desc='Mise en place Docker', load=3, actual=3)
TCI = Task(id='TCI', desc='Intégration Travis CI', load=1, actual=1)
AS = Task(id='AS', desc='Analyse sujet', load=2, actual=3)
CS = Task(id='CS', desc='Conception jeu scrabble', load=3, actual=3)

prj.add_task(TD)
prj.add_task(R)
prj.add_task(PT)
prj.add_task(DJ)
prj.add_task(DJC)
prj.add_task(DJF)
prj.add_task(DJWS)
prj.add_task(DP)
prj.add_task(DPC)
prj.add_task(DPF)
prj.add_task(DPWS)
prj.add_task(DA)
prj.add_task(DAC)
prj.add_task(DAF)
prj.add_task(DAWS)
prj.add_task(DAN)
prj.add_task(DANC)
prj.add_task(DANF)
prj.add_task(DANWS)
prj.add_task(DC)
prj.add_task(DCC)
prj.add_task(DCF)
prj.add_task(SWS)
prj.add_task(DOCK)
prj.add_task(TCI)
prj.add_task(AS)
prj.add_task(CS)


# Progress ----
prj.add_progression(date="09/05/2022", who=BP, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=KD, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=LG, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=MA, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=NR, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=SKA, task=TD, workload=0.2, comment="Mise en place architecture github, création pom.xml")
prj.add_progression(date="09/05/2022", who=MA, task=TCI, workload=0.2, comment="Mise en place de travis")
prj.add_progression(date="09/05/2022", who=BP, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=KD, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=LG, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=MA, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=NR, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=SKA, task=AS, workload=0.5, comment="Analyse du sujet en groupe")
prj.add_progression(date="09/05/2022", who=NR, task=PT, workload=0.1, comment="Suivi de projet")
prj.add_progression(date="10/05/2022", who=BP, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=KD, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=LG, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=MA, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=NR, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=SKA, task=CS, workload=0.5, comment="Conception du sujet en groupe")
prj.add_progression(date="10/05/2022", who=BP, task=DPC, workload=0.3, comment="Premier développement de l'architecture du module partie")
prj.add_progression(date="10/05/2022", who=KD, task=DJC, workload=0.3, comment="Premier développement de l'architecture du module joueur")
prj.add_progression(date="10/05/2022", who=LG, task=DANC, workload=0.3, comment="Premier développement de l'architecture du module anagrammeur")
prj.add_progression(date="10/05/2022", who=MA, task=DJC, workload=0.3, comment="Premier développement de l'architecture du module joueur")
prj.add_progression(date="10/05/2022", who=NR, task=DANC, workload=0.3, comment="Premier développement de l'architecture du module anagrammeur")
prj.add_progression(date="10/05/2022", who=SKA, task=DPC, workload=0.3, comment="Premier développement de l'architecture du module partie")
prj.add_progression(date="13/05/2022", who=SKA, task=DAC, workload=0.2, comment="Architecture Appariemment")
prj.add_progression(date="13/05/2022", who=BP, task=DAF, workload=0.2, comment="Developpement fonctionnalité Appariemment")
prj.add_progression(date="15/05/2022", who=NR, task=DAWS, workload=0.2, comment="Developpement webservice Appariemment")
prj.add_progression(date="16/05/2022", who=BP, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=KD, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=LG, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=MA, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=NR, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=SKA, task=DCC, workload=0.1, comment="Architecture classes communes")
prj.add_progression(date="16/05/2022", who=BP, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="16/05/2022", who=KD, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="16/05/2022", who=LG, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="16/05/2022", who=MA, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="16/05/2022", who=NR, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="16/05/2022", who=SKA, task=DCF, workload=0.2, comment="Développement classes communes")
prj.add_progression(date="17/05/2022", who=BP, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=KD, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=LG, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=MA, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=NR, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=SKA, task=TD, workload=0.2, comment="Séance de TD, continuation du développement")
prj.add_progression(date="17/05/2022", who=BP, task=DPF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=KD, task=DJF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=LG, task=DANF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=MA, task=DJF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=NR, task=DANF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=SKA, task=DPF, workload=1, comment="Continuation du développement des classes attribuées")
prj.add_progression(date="17/05/2022", who=NR, task=PT, workload=0.1, comment="Suivi de projet")
prj.add_progression(date="23/05/2022", who=BP, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="23/05/2022", who=KD, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="23/05/2022", who=LG, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="23/05/2022", who=MA, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="23/05/2022", who=NR, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="23/05/2022", who=SKA, task=TD, workload=0.2, comment="Séance de TD, introduction à docker et Spring boot")
prj.add_progression(date="24/05/2022", who=BP, task=SWS, workload=1.3, comment="Mise en place Spring et webservices")
prj.add_progression(date="24/05/2022", who=KD, task=DOCK, workload=1.3, comment="Introduction à Docker")
prj.add_progression(date="24/05/2022", who=LG, task=SWS, workload=1.3, comment="Mise en place Spring et webservices")
prj.add_progression(date="24/05/2022", who=MA, task=DOCK, workload=1.3, comment="Introduction à Docker")
prj.add_progression(date="24/05/2022", who=NR, task=SWS, workload=1.3, comment="Mise en place Spring et webservices")
prj.add_progression(date="24/05/2022", who=SKA, task=SWS, workload=1.3, comment="Mise en place Spring et webservices")
prj.add_progression(date="26/05/2022", who=BP, task=R, workload=0.2, comment="Réunion équipe")
prj.add_progression(date="26/05/2022", who=NR, task=R, workload=0.2, comment="Réunion équipe")
prj.add_progression(date="26/05/2022", who=SKA, task=R, workload=0.2, comment="Réunion équipe")
prj.add_progression(date="30/05/2022", who=BP, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=KD, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=LG, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=MA, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=NR, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=SKA, task=TD, workload=0.2, comment="Séance de TD, suivi de projet")
prj.add_progression(date="30/05/2022", who=MA, task=PT, workload=0.2, comment="Suivi de projet, organisation du excel de tracking")
prj.add_progression(date="30/05/2022", who=NR, task=DANF, workload=0.2, comment="Développement anagrammeur")
prj.add_progression(date="30/05/2022", who=LG, task=DANF, workload=0.2, comment="Développement anagrammeur")
prj.add_progression(date="31/05/2022", who=MA, task=PT, workload=0.5, comment="Diagramme de GANTT, mise à jour du tracking")
prj.add_progression(date="07/06/2022", who=BP, task=DPWS, workload=0.1, comment="Tests spring pour Partie")
prj.add_progression(date="07/06/2022", who=KD, task=DJF, workload=0.5, comment="Developpement fonctionnel joueur")
prj.add_progression(date="07/06/2022", who=LG, task=DANF, workload=0.25, comment="Developpement fonctionnel Anagrammeur")
prj.add_progression(date="07/06/2022", who=MA, task=DJF, workload=0.5, comment="Developpement fonctionnel joueur")
prj.add_progression(date="07/06/2022", who=NR, task=DANF, workload=0.25, comment="Developpement fonctionnel Anagrammeur")
prj.add_progression(date="07/06/2022", who=SKA, task=DPWS, workload=0.4, comment="Tests spring pour Partie")
prj.add_progression(date="07/06/2022", who=SKA, task=DJWS, workload=0.1, comment="Developpement webservice joueur")
prj.add_progression(date="07/06/2022", who=MA, task=PT, workload=0.1, comment="Suivi des tâches, rectification du inital workload")
prj.add_progression(date="07/06/2022", who=NR, task=DANWS, workload=0.25, comment="Developpement web service Anagrammeur")
prj.add_progression(date="07/06/2022", who=LG, task=DANWS, workload=0.25, comment="Developpement web service Anagrammeur")
prj.add_progression(date="07/06/2022", who=NR, task=DOCK, workload=0.1, comment="Mise en place Docker pour Anagrammeur")
prj.add_progression(date="07/06/2022", who=LG, task=DOCK, workload=0.1, comment="Mise en place Docker pour Anagrammeur")
prj.add_progression(date="07/06/2022", who=BP, task=TD, workload=0.2, comment="Vidéo de monsieur Renevier")
prj.add_progression(date="07/06/2022", who=MA, task=DCF, workload=0.1, comment="Developpement classes communes : ajout de méthodes dans Plateau et nouvelle classe Placement")
prj.add_progression(date="08/06/2022", who=KD, task=DCF, workload=0.1, comment="Developpement classes communes : ajout de méthodes dans Plateau et nouvelle classe Placement")
prj.add_progression(date="09/06/2022", who=SKA	, task=DPF	, workload=0.3, comment="Developpement fonctionnalités partie")
prj.add_progression(date="09/06/2022", who=NR	, task=DOCK, workload=0.1, comment="Intégration docker toutes classes")
prj.add_progression(date="09/06/2022", who=LG	, task=DOCK, workload=0.1, comment="Intégration docker toutes classes")
prj.add_progression(date="09/06/2022", who=NR	, task=DANWS, workload=0.1, comment="Web service pour Anagrammeur")
prj.add_progression(date="09/06/2022", who=LG	, task=DANWS, workload=0.1, comment="Web service pour Anagrammeur")
prj.add_progression(date="10/06/2022", who=KD	, task=DJF	, workload=0.2, comment="Développement fonctionnalités joueur : joueur choisi un mot et le place")
prj.add_progression(date="10/06/2022", who=MA	, task=DJF	, workload=0.2, comment="Développement fonctionnalités joueur : joueur choisi un mot et le place")
prj.add_progression(date="10/06/2022", who=KD	, task=DCF	, workload=0.05, comment="Développement d'une classe pour l'échange avec Partie")
prj.add_progression(date="10/06/2022", who=MA	, task=DJF	, workload=0.05, comment="Développement d'une classe pour l'échange avec Partie")
prj.add_progression(date="10/06/2022", who=BP	, task=DPF	, workload=0.2, comment="Tests fonctionnels pour classe Partie")
prj.add_progression(date="13/06/2022", who=KD	, task=DJWS, workload=0.5, comment="Intégration spring à Joueur")
prj.add_progression(date="13/06/2022", who=MA	, task=PT	, workload=0.3, comment="Redaction du rapport final de suivi de projet et inscription dans le tracking history")
prj.add_progression(date="13/06/2022", who=LG	, task=PT	, workload=0.2, comment="Script python")
prj.add_progression(date="13/06/2022", who=BP	, task=DPF	, workload=0.2, comment="Développement fonctionnalités partie")
prj.add_progression(date="13/06/2022", who=KD	, task=DJWS, workload=0.2, comment="Intégration Spring à Joeur")
prj.add_progression(date="13/06/2022", who=SKA	, task=DJWS, workload=0.05, comment="Webservice joueur")
prj.add_progression(date="13/06/2022", who=SKA	, task=DPWS, workload=0.05, comment="Webservice partie")
prj.add_progression(date="13/06/2022", who=SKA	, task=DPF	, workload=0.1, comment="Test intégration partie")
prj.add_progression(date="14/06/2022", who=MA	, task=PT	, workload=0.2, comment="Redaction du rapport final de suivi de projet, inscription tracking history, correction du tableau croisé et des workloads")
prj.add_progression(date="14/06/2022", who=KD	, task=DJWS, workload=0.2, comment="Webservice joueur")
prj.add_progression(date="14/06/2022", who=SKA	, task=DPWS, workload=0.2, comment="Webservice partie")
prj.add_progression(date="14/06/2022", who=BP	, task=DPF	, workload=0.2, comment="Test partie")
prj.add_progression(date="14/06/2022", who=LG	, task=PT	, workload=0.2, comment="Script python")
prj.add_progression(date="14/06/2022", who=NR	, task=DANWS, workload=0.2, comment="Web Service pour Anagrammeur")




prj.print_summary()
