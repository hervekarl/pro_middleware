#!/bin/bash

# Liste des microservices
configs=("myconfig" "mygateway" "myDiscorveryServer")
services=("PatientManager" "dosmed" "RHManager" "PharmacyManager")

# Couleurs pour affichage
GREEN="\e[32m"
RESET="\e[0m"

# Étape 1 : Démarrage des services de configuration
echo -e "${GREEN}🚀 Démarrage des services de configuration...${RESET}"

for conf in "${configs[@]}"; do
  echo -e "${GREEN}▶️  Lancement de $conf...${RESET}"
  cd "$conf" || exit 1
  nohup mvn spring-boot:run > "../${conf}.log" 2>&1 &
  cd ..
done

# Étape 2 : Démarrage des microservices métiers
echo -e "${GREEN}🚀 Démarrage des microservices métiers...${RESET}"

for service in "${services[@]}"; do
  echo -e "${GREEN}▶️  Lancement de $service...${RESET}"
  cd "$service" || exit 1
  nohup mvn spring-boot:run > "../${service}.log" 2>&1 &
  cd ..
done

echo -e "${GREEN}✅ Tous les services sont lancés. Vérifiez les logs dans les fichiers *.log${RESET}"
