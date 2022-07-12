import { Flex, Text } from '@chakra-ui/react'

export function Logo () {
  return (
    <Flex as="a" href="/">
      <Text fontSize={40} fontWeight="bold" color="yellow.800">agro</Text>
      <Text fontSize={40} fontWeight="bold" color="green.600">.tech</Text>
    </Flex>
  )
}
