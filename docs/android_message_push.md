# Android message push

## But

Les messages push permettent de notifier une application de la récéption d'un message. Ils permettent par exemple d'envoyer des messages de notification pour stimuler le réengagement des utilisateurs ou alors tout simplement pour l'envoie de donnée.

Les notifications push ont été lancées pour la première fois en 2009 par Apple avec le "Apple Push Notification Service" et ont été introduites par Google en 2010 avec "Google Cloud to Device Messaging". Ce dernier a ensuite été fermé en 2015 pour être remplacé par Firebase cloud messaging.

Il faut quand même noter que les smartphones Android doivent possèder le services de Google installé (Google play service). Sans ce service la communication push n'est pas possible ainsi que tout les autres services proposé par Firebase. Il n'est pas rare d'avoir des smartphones en Asie qui posssède pas ce service et il faut donc trouver une autre manière d'envoyer des messages push, mais souvent celà ne fonctionne pas très bien à cause des restriction pour économiser la batterie.

## les problématiques qu’elle peut résoudre

Un point fort de ce service, est qu'il est entièrement gratuit. Il permet donc d'implémenter une communication d'un serveur aux smartphones sans frais et sans prise de tête.

Il permet de réduire la consommation de la batterie. En effet, si chaque application du smartphone contient une tâche de fond devant maintenir une connection tcp pour vérifier la récéption d'un message, la batterie ne tiendrais pas longtemps. Ce service est donc unique sur le smartphone et va tout simplement réveiller les applications qui doivent réaliser certaines tâches. De plus, réaliser une application souhaitant une fonctionnalité similaire aux messages push mais sans utiliser les services de Firebase devront se battre avec Android pour l'empêcher de les tuer. Les tâches ne sont pas forcément exécutée si l'appareil trouve qu'elle n'est pas utile ou qu'elle est trop gourmande et il est obligatoire d'afficher une notification pour avertir à l'utilisateur qu'une application tourne en fond et consomme donc la batterie.

## Alternatives

Il n'existe pas réellement d'alternative car tous les autres service passeront par Firebase pour afficher les messages push. Ce que les "alternatives" proposent est souvent uniquement une meilleure interface et analyse des données.

## comment est-ce qu’elle s’utilise

1. Ajouter Firebase à son application
2. créer un projet Firebase
3. Ajouter un service à son application
4. Envoyer les messages push

Pour envoyer un data message par une requete post:

header:

-   Content-Type: application/json
-   Authorization: key=<your-server-key>

body:

```json
{
    "data": {
        "test": "coucou"
    },
    "to": "target-token"
}
```

## limitations

-   Certain constructeur n'hésite pas à restreindre les applications dans le but de faire durer la batterie plus longtemps, par conséquent il est possible que les notifications/messages ne soient pas reçu par l'application.
-   La taille des messages est limité

## points d’attention
