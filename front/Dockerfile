

FROM node AS node-base
WORKDIR /front
COPY ./package.json ./package-lock.json ./
COPY ./vue.config.js ./
COPY ./babel.config.js ./
COPY ./public/ ./public
COPY ./src/ ./src
RUN ["npm", "install"]
RUN ["npm", "run", "build"]
ENTRYPOINT ["npm", "run", "serve"]





