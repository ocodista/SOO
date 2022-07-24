import { Table, TableContainer, Tbody, Td, Th, Thead, Tr } from '@chakra-ui/react'
import { EstanteType } from '../../services/types'

type ShelfTableProps = {
  estantes: EstanteType[]
}

export function ShelfTable ({ estantes }: ShelfTableProps) {
  const renderDetalhes = (estante: EstanteType) => {
    let totalSensores = 0
    let totalAtuadores = 0
    let totalNichos = 0
    let totalDisponiveis = 0

    estante.prateleiras.forEach(prateleira => {
      prateleira.nichos.forEach(nicho => {
        totalNichos += 1
        nicho.dispositivos.forEach(dispositivo => {
          if (dispositivo.tipoDispositivo.nome.toLowerCase() === 'sensor') {
            totalSensores += 1
          }
          if (dispositivo.tipoDispositivo.nome.toLowerCase() === 'atuador') {
            totalAtuadores += 1
          }
        })
        if (!nicho.dispositivos.length) {
          totalDisponiveis += 1
        }
      })
    })

    return (
      <Tr key={estante.id}>
        <Td textAlign="center" >{estante.descricao}</Td>
        <Td textAlign="center">{totalSensores}</Td>
        <Td textAlign="center">{totalAtuadores}</Td>
        <Td textAlign="center">{totalNichos}</Td>
        <Td textAlign="center">{totalDisponiveis}</Td>
      </Tr>
    )
  }

  return (
    <TableContainer w="100%">
      <Table size="lg" variant="striped" colorScheme="green">
        <Thead>
          <Tr>
            <Th textAlign="center">Descrição</Th>
            <Th textAlign="center">Sensores</Th>
            <Th textAlign="center">Atuadores</Th>
            <Th textAlign="center">Total de Nichos</Th>
            <Th textAlign="center">Disponíveis</Th>
          </Tr>
        </Thead>
        <Tbody>
          {estantes.map((estante) => (
            <>
              {renderDetalhes(estante)}
            </>
          ))}
        </Tbody>
      </Table>
    </TableContainer>
  )
}
