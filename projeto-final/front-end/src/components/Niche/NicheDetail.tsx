import { HStack, Switch, Text } from '@chakra-ui/react'
import { DispositivoType } from '../../services/types'

export type NicheDetailProps = {
  nicheId: number;
  dispositivos: DispositivoType[];
}

export function NicheDetail (props: NicheDetailProps) {
  const { nicheId, dispositivos } = props

  return (
      <>
        <Text fontSize="20px" fontWeight="bold" color="white">Nicho {nicheId}</Text>
        {dispositivos.map(dispositivo => (
          <>
            {dispositivo.categoriaDispositivo && (
              <HStack key={dispositivo.id} width="100%" height="fit-content" justifyContent="space-between">
                <Text fontSize="14px" fontWeight="semibold" color="white">{dispositivo.categoriaDispositivo.nome}</Text>
                <Text fontSize="14px" fontWeight="semibold" color="white">{dispositivo.value} {dispositivo.categoriaDispositivo.medida}</Text>
              </HStack>
            )}
            {dispositivo.tipoDispositivo.nome === 'Atuador' && (
              <HStack key={dispositivo.id} width="100%" height="fit-content" justifyContent="space-between">
                <Text fontSize="14px" fontWeight="semibold" color="white">Iluminação</Text>
                <Switch size="md" colorScheme="teal" isChecked={Boolean(dispositivo.value)}/>
              </HStack>
            )}
          </>
        ))}
      </>
  )
}
