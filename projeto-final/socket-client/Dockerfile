# base image
FROM node:alpine

ARG REACT_APP_HOST_SOCKET_URL
ENV REACT_APP_HOST_SOCKET_URL $REACT_APP_HOST_SOCKET_URL

# create & set working directory
RUN mkdir -p /usr/src
WORKDIR /usr/src

# copy source files
COPY . /usr/src

# install dependencies
RUN npm install

# start app
RUN npm run build
EXPOSE 3001
CMD npm run start