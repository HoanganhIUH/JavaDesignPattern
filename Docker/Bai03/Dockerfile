# Build stage
FROM node:18-alpine as build

# Set working directory
WORKDIR /app

# Copy package files
COPY package*.json ./

# Install all dependencies (including dev dependencies) for building
RUN npm install

# Copy application code
COPY . .

# Build the application
RUN npm run build

# Production stage
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Install serve and curl for healthcheck
RUN apk add --no-cache curl && \
    npm install -g serve && \
    npm cache clean --force

# Copy built files from build stage
COPY --from=build /app/build ./build

# Set environment variables
ENV NODE_ENV=production
ENV PORT=3000

# Expose port 3000
EXPOSE 3000

# Add healthcheck using curl
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:3000 || exit 1

# Start the application
CMD ["serve", "-s", "build", "-l", "3000"] 