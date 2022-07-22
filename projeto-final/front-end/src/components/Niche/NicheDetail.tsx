import { Divider, Flex, GridItem, HStack, Switch, Text } from '@chakra-ui/react'
import { ChangeEvent, useState } from 'react'

export type NicheDetailProps = {
  temperature: number;
  isLightOn: boolean;
  isWaterOn: boolean;
  moisture: number;
  nicheId: number;
  isEmpty?: boolean;
}

export function NicheDetail (props: NicheDetailProps) {
  const { isLightOn, isWaterOn, moisture, temperature, nicheId, isEmpty } = props
  const [isWaterCheck, setIsWaterCheck] = useState<boolean>(isWaterOn)
  const [isLightCheck, setIsLightCheck] = useState<boolean>(isLightOn)

  function handleWaterCheck (e: ChangeEvent<HTMLInputElement>): void {
    setIsWaterCheck(!isWaterCheck)
  }

  function handleLightCheck (e: ChangeEvent<HTMLInputElement>): void {
    setIsLightCheck(!isLightCheck)
  }

  return (
    <GridItem
      as={Flex}
      flexDirection="column"
      gap="8px"
      borderRadius="8px"
      bg="yellow.800"
      opacity="0.7"
      padding="8px"
    >
      {!isEmpty
        ? (
        <>
          <Text fontSize="20px" fontWeight="bold" color="white">Nicho {nicheId}</Text>
          <HStack width="100%" height="fit-content" justifyContent="space-between">
            <Text fontSize="14px" fontWeight="semibold" color="white">Temperatura</Text>
            <Text fontSize="14px" fontWeight="semibold" color="white">{temperature} º C</Text>
          </HStack>
          <HStack width="100%" height="fit-content" justifyContent="space-between">
            <Text fontSize="14px" fontWeight="semibold" color="white">Iluminação</Text>
            <Switch size="md" colorScheme="teal" isChecked={isLightCheck} onChange={handleLightCheck} />
          </HStack>

          <Divider bgColor="" orientation='horizontal' />

          <HStack width="100%" height="fit-content" justifyContent="space-between">
            <Text fontSize="14px" fontWeight="semibold" color="white">Umidade</Text>
            <Text fontSize="14px" fontWeight="semibold" color="white">{moisture}%</Text>
          </HStack>

          <HStack width="100%" height="fit-content" justifyContent="space-between">
            <Text fontSize="14px" fontWeight="semibold" color="white">Água</Text>
            <Switch size="md" colorScheme="teal" isChecked={isWaterCheck} onChange={handleWaterCheck}/>
          </HStack>
        </>
          )
        : (
        <HStack width="100%" height="100%" justifyContent="center">
          <Text fontSize="20px" fontWeight="bold" color="white">Vazio</Text>
        </HStack>
          )}
    </GridItem>
  )
}
