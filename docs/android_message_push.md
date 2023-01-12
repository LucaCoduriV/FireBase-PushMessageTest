# Android message push

## But

Les messages push permettent de notifier une application de la récéption d'un message. Ils permettent par exemple d'envoyer des messages de notification pour stimuler le réengagement des utilisateurs ou alors dans le contexte d'une application de messagerie instatanée de recevoir les messages avec une charge utile.

Les notifications push sont des messages destinés à une application d'un smartphone, même lorsque l'application en question n'est pas ouverte. Elles sont utilisées par les éditeurs d'applications pour atteindre directement leurs utilisateurs et sont utiles pour les utilisateurs car elles fournissent des informations immédiates et pertinentes.

Les notifications push ont été lancées pour la première fois en 2009 par Apple avec le "Apple Push Notification Service" et ont été introduites par Google en 2010 avec "Google Cloud to Device Messaging".

## les problématiques qu’elle peut résoudre

Un des problème que ce service essaye de résoudre est l'autonomie de la batterie. En effet, si chaque application du smartphone contient une tâche de fond devant maintenir une connection tcp pour vérifier de la récéption d'un message, la batterie ne tiendrais pas longtemps. De plus, la politique d'android essaye de rendre cette tâche la plus compliquée possible.

-   Les tâches ne sont pas forcément exécutée si l'appareil trouve qu'elle n'est pas utile.
-   Il est obligatoire d'afficher une notification pour avertir à l'utilisateur qu'une application tourne en fond.
-   Un service peut-être tué à n'importe quel moment.
-   ...

Pour résoudre ce problème, les messages push ont été mis en place. Ce service permet donc d'avoir une seule connection constament ouverte et qui n'est jamais tué pour toutes les applications du smartphone. Chaque message contient un identifiant qui permet au smartphone de savoir quel application elle doit réveillé.

## comment est-ce qu’elle s’utilise

## limitations

-   Certain constructeur n'hésite pas à restreindre les applications dans le but de faire durer la batterie plus longtemps, par conséquent il est possible que les notifications/messages ne soient pas reçu par l'application.
-   La taille des messages est limité

## points d’attention
