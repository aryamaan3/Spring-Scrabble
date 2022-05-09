# Commandes Git pour un flux de travail simple

Les étapes suivantes suffisent pour créer un pull request.

## Créer une fork
Cliquez simplement sur le bouton "fork" dans le repo sur GitHub et suivez les instructions.

## Clonez votre fork
La commande clone standard crée un repo git local à partir de votre fork distant sur GitHub. Faites attention à cloner **votre** fork et non le repo principal. 
Cette étape n'est nécessaire que pour votre premier Issue.
``` bash
git clone <url du repo>
```

## Créer une branche
Idéalement, créez une branche pour chaque Issue sur votre fork local.
Pour cela, nous vérifions d'abord la branche principale, puis nous en créons une nouvelle.

```bash 
git checkout main
git pull origin main
git checkout -b <ID Issue>
```

<div id="add"></div>

## Avant le commit
Après avoir modifié le code, il doit être ajouté/stage avant de commit

Ajouter/Stage **tous** vos changements.
```bash
git add -A
```
Ajouter/Stage **certains** fichiers uniquement
```bash
git add <nom du fichier>
```

## Commit. 
Le message doit contenir l'ID du problème.
```bash
git commit -m "<ID Issue>"
```
## Push
Dans votre espace de travail, utilisez la commande git push pour télécharger vos modifications sur votre fork distant sur GitHub.
**UN SEUL COMMIT PAR ISSUE LORS DU PUSH**
```bash
git push origin <nom de votre branche>
```

## Pull request
Après avoir pushé vos modifications, vous pouvez créer un pull request.\
Cliquez sur le tab "Pull request" dans le repo sur GitHub.\
Cliquez sur le bouton "New pull request" et suivez les instructions.\
Choissisez la branche principale comme base et la branche de votre fork comme compare.\
Mettez le titre de votre Issue comme titre du pull request.


## Gardez vos commits propres
Vous pouvez choisir d'avoir plusieurs commits localement, mais lors du push, vous ne devriez avoir qu'un **seul** commit. Cela simplifie le revert de commit code en cas de bugs et encapsule les fonctionnalités.

Au cas où vous auriez plusieurs commits. Squash en un seul commit.
```bash
git reset --soft HEAD~<nombre de commits à squash> &&
git commit -m "<ID Issue>"
git push -f origin <nom de votre branche>
```

## Modifier votre push
Dans le cas où une modification est nécessaire après l'ouverture d'une pull request.
[Modifiez et ajoutez les changements](#add)
Puis.
```bash
git commit --amend -m "<ID Issue>"
git push -f origin <nom de votre branche>
```