eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519_jenkins
ssh -vT git@github.com
