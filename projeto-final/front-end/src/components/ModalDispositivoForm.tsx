import { Button, Flex, Input, InputGroup, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay, Select, Text, useDisclosure, VStack } from '@chakra-ui/react'
import { useEffect, useState } from 'react'
import { DeviceService } from '../services/DeviceService'
import { ShelfService } from '../services/ShelfService'
import { CategoriaDispositivoType, NichoType, TipoDispositivoType } from '../services/types'

export function ModalDispositivoForm () {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const [categorias, setCategorias] = useState<CategoriaDispositivoType[]>([])
  const [tipos, setTipos] = useState<TipoDispositivoType[]>([])
  const [nichos, setNichos] = useState<NichoType[]>([])

  const [idCategoriaDispositivo, setIdCategoriaDispositivo] = useState<number>(0)
  const [idNicho, setIdNicho] = useState<number>(0)
  const [idTipoDispositivo, setIdTipoDispositivo] = useState<number>(0)
  const [value, setValue] = useState<number>(0)

  useEffect(() => {
    const fetchDevices = async () => {
      const categoriasDispositivo = await DeviceService.getAllCategoryDevices()
      setCategorias(categoriasDispositivo)
      const tipoDispositivos = await DeviceService.getAllTypeDevices()
      setTipos(tipoDispositivos)
      const nichosFetch = await ShelfService.getAllNiches()
      setNichos(nichosFetch)
    }

    fetchDevices()
  }, [])

  const salvar = () => {
    console.log({
      idCategoriaDispositivo,
      idNicho,
      idTipoDispositivo,
      value
    })
    DeviceService.createDevice({
      idCategoriaDispositivo,
      idNicho,
      idTipoDispositivo,
      value
    }).then(() => {
      alert('Cadastro efetuado com sucesso!')
      setIdCategoriaDispositivo(0)
      setIdNicho(0)
      setIdTipoDispositivo(0)
      setValue(0)
      onClose()
    }).catch((error) => {
      console.error(error)
      alert('Houve erro ao efetuar o cadastro')
    })
  }

  return (
    <>
      <Button onClick={onOpen} size="lg" bgColor="yellow.800" color="white" _hover={{ bgColor: 'green.600' }}>
        <Text>Adicionar Dispositivo</Text>
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
                  <Text>Categoria</Text>
                  <Select onChange={(e) => setIdCategoriaDispositivo(Number(e.currentTarget.value))} placeholder='Selecione a categoria'>
                    {categorias.map(categoria => (
                      <option key={categoria.id} value={categoria.id}> {categoria.nome}</option>
                    ))}
                  </Select>
                </VStack>
              </InputGroup>
              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                  <Text>Tipo de dispositivos</Text>
                  <Select onChange={(e) => setIdTipoDispositivo(Number(e.currentTarget.value))} placeholder='Selecione o tipo'>
                    {tipos.map(tipo => (
                      <option key={tipo.id} value={tipo.id} > {tipo.nome}</option>
                    ))}
                  </Select>
                </VStack>
              </InputGroup>

              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                  <Text>Nicho</Text>
                  <Select onChange={(e) => setIdNicho(Number(e.currentTarget.value))} placeholder='Selecione o nicho'>
                    {nichos.map(nicho => (
                      <option key={nicho.id} value={nicho.id}> Nicho {nicho.id} - Prateleira {nicho.idPrateleira} </option>
                    ))}
                  </Select>
                </VStack>
              </InputGroup>

              <InputGroup>
                <VStack alignItems="flex-start" width="100%">
                  <Text>Valor</Text>
                  <Input placeholder="Ex: 20" value={value} onChange={(e) => setValue(Number(e.currentTarget.value))}/>
                </VStack>
              </InputGroup>
            </Flex>
          </ModalBody>
          <ModalFooter>
            <Button colorScheme='blue' mr={3} onClick={salvar}>
              Salvar
            </Button>
            <Button variant='ghost' onClick={onClose}>Cancelar</Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  )
}
