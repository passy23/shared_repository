def call (String CONTAINER_NAME, String IMAGE_NAME, String IMAGE_TAG) {
    sh '''
                        docker rm -f frontendapp
                        echo "Launch test container"
                        docker run -d -p 5000:5000 --name ${CONTAINER_NAME} ${IMAGE_NAME}:${IMAGE_TAG}
                        sleep 5
                        echo "test container"
                        curl -I http://$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' ${CONTAINER_NAME}):5000
                        echo "delete the conatiner"
                        docker rm -f ${CONTAINER_NAME}

                    '''


}