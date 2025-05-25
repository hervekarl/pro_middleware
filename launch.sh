#!/bin/bash

# Couleurs pour affichage
GREEN="\e[32m"
RESET="\e[0m"

# Liste des microservices
configs=("myconfig" "mygateway" "myDiscorveryServer")
services=("PatientManager" "dosmed" "RHManager" "PharmacyManager")
all_services=("${configs[@]}" "${services[@]}")

# Étape 0 : Installation des dépendances (mvn install)
echo -e "${GREEN}📦 Installation des dépendances pour tous les services...${RESET}"
for ser in "${all_services[@]}"; do
  echo -e "${GREEN}▶️  Installation de $ser...${RESET}"
  cd "$ser" || { echo "❌ Dossier $ser introuvable."; exit 1; }
  mvn install -DskipTests
  cd ..
done

# Étape 1 : Démarrage des services de configuration
echo -e "${GREEN}🚀 Démarrage des services de configuration...${RESET}"

for conf in "${configs[@]}"; do
  echo -e "${GREEN}▶️  Lancement de $conf...${RESET}"
  cd "$conf" || { echo "❌ Dossier $conf introuvable."; exit 1; }
  nohup mvn spring-boot:run > "../${conf}.log" 2>&1 &
  cd ..
done

# Étape 2 : Démarrage des microservices métiers
echo -e "${GREEN}🚀 Démarrage des microservices métiers...${RESET}"

for service in "${services[@]}"; do
  echo -e "${GREEN}▶️  Lancement de $service...${RESET}"
  cd "$service" || { echo "❌ Dossier $service introuvable."; exit 1; }
  nohup mvn spring-boot:run > "../${service}.log" 2>&1 &
  cd ..
done

echo -e "${GREEN}✅ Tous les services sont lancés. Vérifiez les logs dans les fichiers *.log${RESET}"
