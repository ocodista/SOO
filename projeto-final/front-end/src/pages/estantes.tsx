import { Flex, Grid, Table, TableContainer, Tbody, Td, Text, Th, Thead, Tr } from '@chakra-ui/react'
import { NextPage } from 'next'
import { Header } from '../components/Header/Header'
import { ShelfService } from '../services/ShelfService'
import { EstanteType } from '../services/types'

interface IEstantes {
  estantes ?: EstanteType[]
}

const Estantes: NextPage = ({ estantes }: IEstantes) => {
  console.log(estantes)
  return (
    <Grid
      templateAreas={`
        "header"
        "main"
      `}
      templateRows="1fr 11fr"
      templateColumns="12fr"
      gap="5rem"
      padding="2rem"
      height="100%"
    >
      <Header />
      <Flex border="1px solid" borderColor="gray.300" borderRadius="0.5rem" padding="1rem" direction="column" alignItems="center">
        {estantes
          ? <TableContainer w="100%">
          <Table size="lg" variant='striped' colorScheme="yellow">
            <Thead>
              <Tr>
                <Th>Descrição</Th>
                <Th isNumeric>Sensores</Th>
                <Th isNumeric>Atuadores</Th>
                <Th isNumeric>Total de Nichos</Th>
                <Th isNumeric>Disponíveis</Th>
              </Tr>
            </Thead>
            <Tbody>
              {estantes.map(estante => (
                <Tr key={estante.id}>
                  <Td>{estante.descricao}</Td>
                  <Td isNumeric>{estante.prateleiras.length}</Td>
                  <Td isNumeric>{estante.qtdNichosPorPrateleira}</Td>
                  <Td isNumeric>{estante.qtdPrateleiras}</Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </TableContainer>
          : <Text>Não há estantes</Text>}
      </Flex>
    </Grid>
  )
}
export default Estantes

Estantes.getInitialProps = async (context) => {
  const estantes = await ShelfService.getAllShelfs()
  console.log('getInitialProps', estantes)
  return { estantes }
}
