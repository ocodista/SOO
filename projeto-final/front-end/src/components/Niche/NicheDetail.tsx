import { Divider, Flex, HStack, Switch, Text } from '@chakra-ui/react'
import { DispositivoType } from '../../services/types'

export type NicheDetailProps = {
  nicheId: number;
  dispositivos: DispositivoType[];
}

export function NicheDetail (props: NicheDetailProps) {
  const { nicheId, dispositivos } = props

  return (
      <Flex direction="column" justifyContent="space-between" height="100%">
        <Text fontSize="20px" fontWeight="bold" color="white">Nicho {nicheId}</Text>
        <Divider orientation="horizontal" borderColor="white" />
        {dispositivos.map(dispositivo => (
          <>
            {dispositivo.categoriaDispositivo && dispositivo.tipoDispositivo.nome === 'Sensor' && (
              <HStack key={dispositivo.id} width="100%" height="fit-content" justifyContent="space-between">
                <Text fontSize="14px" fontWeight="semibold" color="white">{dispositivo.categoriaDispositivo.nome}</Text>
                <Text fontSize="14px" fontWeight="semibold" color="white">{dispositivo.value} {dispositivo.categoriaDispositivo.medida}</Text>
              </HStack>
            )}
            {dispositivo.tipoDispositivo.nome === 'Atuador' && (
              <HStack key={dispositivo.id} width="100%" height="fit-content" justifyContent="space-between">
                <Text fontSize="14px" fontWeight="semibold" color="white">{dispositivo.categoriaDispositivo.nome}</Text>
                <Switch size="md" colorScheme="teal" isChecked={Boolean(dispositivo.value)}/>
              </HStack>
            )}
          </>
        ))}
      </Flex>
  )
}
