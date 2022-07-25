import { useState } from 'react'
import { Button, Flex, Input, InputGroup, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, Text, useDisclosure, VStack } from '@chakra-ui/react'
import { ShelfService } from '../services/ShelfService'
import { addEstante } from '../store/estante/actions'
import { useDispatch } from 'react-redux'
import { EstanteType } from '../services/types'

export function ModalEstanteForm () {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const [descricao, setDescricao] = useState<string>('')
  const [qtdNicho, setQtdNicho] = useState<number>(0)
  const [qtdPrateleiras, setQtdPrateleiras] = useState<number>(0)
  const dispatch = useDispatch()

  const salvar = () => {
    if (!descricao || !qtdNicho || !qtdPrateleiras) {
      alert('Preencha todos os campos')
    } else {
      ShelfService.createShelf({
        descricao,
        qtdNichosPorPrateleira: qtdNicho,
        qtdPrateleiras
      }).then((id) => {
        alert('Cadastro feito com sucesso')
        const estante: EstanteType = {
          id,
          descricao,
          qtdNichosPorPrateleira: qtdNicho,
          qtdPrateleiras,
          prateleiras: new Array(qtdPrateleiras).fill({
            nichos: new Array(qtdNicho).fill({
              dispositivos: []
            })
          })
        }
        dispatch(addEstante({ estante }))
        setDescricao('')
        setQtdNicho(0)
        setQtdPrateleiras(0)
        onClose()
      }).catch((error) => {
        console.error(error)
        alert('Houve um erro ao efetuar o cadastro')
      })
    }
  }

  const changeQtdPrateleiras = (value: number) => {
    if (value > 0 && value <= 3) {
      setQtdPrateleiras(value)
    }
  }

  const changeQtdNichos = (value: number) => {
    if (value > 0 && value <= 3) {
      setQtdNicho(value)
    }
  }

  return (
    <>
      <Button onClick={onOpen} size="lg" bgColor="yellow.800" color="white" _hover={{ bgColor: 'green.600' }}>
        <Text>Adicionar estante</Text>
      </Button>
      <Modal
        isCentered
        onClose={onClose}
        isOpen={isOpen}
        motionPreset='slideInBottom'
      >
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Adicionar nova estante</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Flex direction="column" width="100%" gap="1rem">
              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                  <Text>Descrição</Text>
                  <Input
                    placeholder="Ex: Plantas medicinais"
                    value={descricao}
                    onChange={(e) => setDescricao(e.currentTarget.value)}
                  />
                </VStack>
              </InputGroup>
              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                  <Text>Quantidade de prateleiras</Text>
                  <Input
                    placeholder="Ex: 2"
                    value={qtdPrateleiras}
                    onChange={(e) => changeQtdPrateleiras(Number(e.currentTarget.value))}
                  />
                </VStack>
              </InputGroup>

              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                <Text>Quantidade de nichos</Text>
                <Input
                  placeholder="Ex: 2"
                  value={qtdNicho}
                  onChange={(e) => changeQtdNichos(Number(e.currentTarget.value))}
                />
                </VStack>
              </InputGroup>
            </Flex>
          </ModalBody>
          <ModalFooter>
            <Button colorScheme='blue' mr={3} onClick={salvar}>
              Salvar
            </Button>
            <Button variant='ghost' onClick={onClose} >Cancelar</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  )
}
