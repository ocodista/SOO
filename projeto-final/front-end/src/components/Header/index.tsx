import { Flex } from '@chakra-ui/react'
import { Logo } from './Logo'
import { Navigation } from './Navigation'

export function Header () {
  return (
    <Flex
      as="header"
      alignItems="center"
      justifyContent="space-between"
    >
      <Logo />
      <Navigation />
    </Flex>
  )
}
