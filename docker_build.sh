prefix="group1-team3"
app="accounts-service-by-jenkins"
ver="0.2.20"

echo "docker build -t k8s-vga-worker1:5000/${prefix}-${app}:v${ver}"
docker build --platform=linux/amd64 -t k8s-vga-worker1:5000/${prefix}-${app}:v${ver} ./
#docker push k8s-vga-worker1:5000/${prefix}-${app}:v${ver}