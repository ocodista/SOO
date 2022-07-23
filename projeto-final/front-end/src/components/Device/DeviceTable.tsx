import { Button, Flex, Table, TableContainer, Tbody, Td, Text, Th, Thead, Tr } from '@chakra-ui/react'
import { DispositivoType } from '../../services/types'

type DeviceTableProps = {
  dispositivos: DispositivoType[]
}

export function DeviceTable ({ dispositivos }: DeviceTableProps) {
  const renderDetalhes = (tipo: string) => {
    console.log(dispositivos)
    return dispositivos.map((dispositivo) => {
      if (dispositivo.tipoDispositivo.nome.toLowerCase() === tipo) {
        return (
          <Tr key={dispositivo.id}>
            <Td textAlign="center">{dispositivo.tipoDispositivo.nome} {dispositivo.id}</Td>
            <Td textAlign="center">{dispositivo.categoriaDispositivo.nome}</Td>
            <Td textAlign="center">{dispositivo.idEstante ?? '-'}</Td>
            <Td textAlign="center">{dispositivo.idNicho}</Td>
            <Td textAlign="center">{dispositivo.value}</Td>
          </Tr>
        )
      }
      return null
    })
  }

  return (
    <>
      <Flex
        border="1px solid"
        borderColor="gray.300"
        borderRadius="0.5rem"
        direction="column"
        width="100%"
        padding="1rem"
      >
        <TableContainer w="100%">
          <Table size="lg" variant="striped" colorScheme="green">
            <Thead>
              <Tr>
                <Th textAlign="center">Sensores</Th>
                <Th textAlign="center">Categoria</Th>
                <Th textAlign="center">Estante</Th>
                <Th textAlign="center">Nicho</Th>
                <Th textAlign="center">Valor Atual</Th>
              </Tr>
            </Thead>
            <Tbody>
              {renderDetalhes('sensor')}
            </Tbody>
          </Table>
        </TableContainer>
        <Flex width="100%" alignItems="end" paddingY="2rem" justifyContent="flex-end">
          <Button size="lg" bgColor="yellow.800" color="white" _hover={{ bgColor: 'green.600' }}>
            <Text>Adicionar Sensor</Text>
          </Button>
        </Flex>
      </Flex>
      <Flex
        border="1px solid"
        borderColor="gray.300"
        borderRadius="0.5rem"
        direction="column"
        width="100%"
        padding="1rem"
      >
        <TableContainer w="100%">
          <Table size="lg" variant="striped" colorScheme="green">
            <Thead>
              <Tr>
                <Th textAlign="center">Atuadores</Th>
                <Th textAlign="center">Categoria</Th>
                <Th textAlign="center">Estante</Th>
                <Th textAlign="center">Nicho</Th>
                <Th textAlign="center">Valor Atual</Th>
              </Tr>
            </Thead>
            <Tbody>
              {renderDetalhes('atuador')}
            </Tbody>
          </Table>
        </TableContainer>
        <Flex width="100%" alignItems="end" paddingY="2rem" justifyContent="flex-end">
          <Button size="lg" bgColor="yellow.800" color="white" _hover={{ bgColor: 'green.600' }}>
            <Text>Adicionar Atuador</Text>
          </Button>
        </Flex>
      </Flex>
    </>
  )
}
