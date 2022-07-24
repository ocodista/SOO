import { Text } from '@chakra-ui/react'
import { useRouter } from 'next/router'

type ItemNavigationProps = {
  text: string,
  newPage: boolean,
  redirect: string
}

export function ItemNavigation ({ text, redirect, newPage = false }: ItemNavigationProps) {
  const { pathname } = useRouter()
  return (
    <Text
      as="a"
      href={redirect}
      target={newPage ? '_blank' : '_self'}
      display="flex"
      alignItems="center"
      height="100%"
      fontSize={20}
      fontWeight="medium"
      padding="16px"
      borderRadius="8px"
      bg={pathname === redirect ? 'yellow.800' : 'unset'}
      color={pathname === redirect ? 'white' : 'yellow.800'}
      _hover={{
        backgroundColor: 'yellow.800',
        color: 'white'
      }}
      >
      {text}
    </Text>
  )
}
