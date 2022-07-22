import { Flex } from '@chakra-ui/react'
import { Logo } from './Logo'
import { Navigation } from './Navigation'

export function Header () {
  return (
    <Flex
      alignItems="center"
      justifyContent="space-between"
      position="sticky"
    >
      <Logo />
      <Navigation />
    </Flex>
  )
}
