# Stage 1: Build Angular app
FROM node:20 AS build

WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# ✅ Install Angular CLI globally so ng is available in PATH
RUN npm install -g @angular/cli

# Copy the rest of the source code
COPY . .

# ✅ Build the Angular app (no --prod needed in Angular 15+)
RUN ng build --configuration production

# Stage 2: Serve with Nginx
FROM nginx:1.25

# Remove default Nginx website
RUN rm -rf /usr/share/nginx/html/*

# Copy Angular build output to Nginx
COPY --from=build /app/dist/email-tracker-ui /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]