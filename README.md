# Review Service

DevOps CI/CD assignment for the Pensionat booking system.

## G Requirements
- **Repository:** Personal repo on GitHub (`stoilsteve-hub/review-service`).
- **CI:** GitHub Actions triggers on push to `main`.
- **Tests:** Automated unit tests execute and pass in the pipeline.
- **Deployment & CD:** Deployed on Render with automatic deploy on push to `main`:  
  https://review-service-9y0q.onrender.com/reviews/room/1

## VG Requirements
- **Secrets & Security:** Docker Hub credentials stored in GitHub Secrets. No secrets or `.env` files in Git.
- **Environment Variables:** Database and port configured via environment variables in Render (`SPRING_DATASOURCE_URL`, `PORT`).
- **Docker Hub:** Automated build and push to Docker Hub on merge:  
  `stoilsteve/review-service:latest`
