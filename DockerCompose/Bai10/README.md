# MySQL with Docker Volumes

This project demonstrates how to run MySQL in Docker with persistent data storage using Docker volumes.

## Configuration

The setup includes:
- MySQL 8.0
- Named volume for data persistence
- Basic user and database configuration

## Environment Variables

- `MYSQL_ROOT_PASSWORD`: Root password (default: rootpassword)
- `MYSQL_DATABASE`: Default database (default: testdb)
- `MYSQL_USER`: Regular user (default: user)
- `MYSQL_PASSWORD`: Regular user password (default: userpassword)

## Usage

1. Start the containers:
```bash
docker-compose up -d
```

2. Stop the containers:
```bash
docker-compose down
```

3. View the logs:
```bash
docker-compose logs mysql
```

## Data Persistence

The MySQL data is stored in a named volume `mysql_data`. This ensures that your data persists even if the container is removed.

To list all volumes:
```bash
docker volume ls
```

Note: The volume will persist unless explicitly removed with `docker volume rm mysql_data`. 