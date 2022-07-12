import { Flex } from '@chakra-ui/react'
import { Logo } from './Logo'
import { Navigation } from './Navigation'

export function Header () {
  return (
    <Flex
      alignItems="center"
      justifyContent="space-between"
      paddingX="16px"
      paddingY="32px"
      position="sticky"
    >
      <Logo />

      <Navigation />
    </Flex>
  )
}
