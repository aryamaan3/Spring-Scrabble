# HowTo : fusionner les conflits

Ce guide explique le processus à suivre pour résoudre les conflits de fusion.\
Cependant, ces étapes ne sont pertinentes que si vous avez correctement suivi [git worklfow](./HowToGit.md).

Commit vos modifications dans votre branche
```bash
git add .
git commit -m "ID Issue"
```

Checkout à la branche scrabble.scrabble et pull
```bash
git checkout scrabble.scrabble
git pull origin scrabble.scrabble
```

Retournez dans votre branche
```bash
git checkout <nom de votre branche>
```

Rebase des changements dans votre branche
```bash
git rebase scrabble.scrabble
```

Ensuite, Git essaiera de déplacer les nouveaux commits dans scrabble.scrabble vers la pointe de votre branche. Voici ce qui pourrait arriver :

1. Espérons que non, mais très probablement oui, Git se plaindra des conflits de fusion.
2. Résolvez les conflits en ouvrant les fichiers en conflit, supprimez les marqueurs insérés et donnez l'impression que vous le souhaitez.
3. Ajouter/stage vos changements.
```
git add <nom du fichier> 
//ou en un bloc 
git add -A
```
4. Continuer le rebase.
```bash
git rebase --continue.
```
5. Rincez et répétez jusqu'à ce que Git arrête de se plaindre.