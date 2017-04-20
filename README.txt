# PrisonerDilemma

Lancez le fichier Main.java pour tester le programme.

Pour modifier les stratégies utilisées par les agents, ouvrez le fichier Main.java avec un éditeur de texte.
Aux lignes suivantes :
14 - Agent agentA = new Agent(new Pavlov());
15 - //Agent agentB = new Agent(new TFT());
16 - AdaptativeAgent agentB = new AdaptativeAgent();
Commentez la ligne 16 et décommentez la ligne 15 si vous voulez utiliser deux agents stratégie.

Pour changer la stratégie qu'un agent doit utiliser, changer 'Pavlov' ou 'TFT' par :
- 'AllC' pour la stratégie gentille
- 'AllD' pour la stratégie méchante
- 'TFT' pour la stratégie donnant-donnant
- 'Mistrust' pour la stratégie méfiante
- 'Pavlov' pour la stratégie de Pavlov
- 'Spiteful' pour la stratégie rancunière
- 'Random' pour la stratégie aléatoire.