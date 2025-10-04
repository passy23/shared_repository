def call (String IMAGE_NAME, String MAGE_TAG, String DOCKER_HUB_USER, String DOCKER_USER, String DOCKER_PASSWORD ) {
 sh '''
        docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}
        docker login -u $DOCKER_USER -p $DOCKER_PASSWORD
        docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}
                            '''
  


}